package com.example.android.devbyteviewer.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.devbyteviewer.R
import com.example.android.devbyteviewer.databinding.DevbyteItemBinding
import com.example.android.devbyteviewer.databinding.FragmentDevByteBinding
import com.example.android.devbyteviewer.domain.DevByteVideo
import com.example.android.devbyteviewer.viewmodels.DevByteViewModel

// show DevBytes คือ ข้อมูลที่ได้มาจาก internet
class DevByteFragment : Fragment() {
    //lazy คือการทำให้เลื่อนการทำงานไปจนกว่าจะถึงจุดที่ต้องทำงาน
    private val viewModel: DevByteViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, DevByteViewModel.Factory(activity.application))
                .get(DevByteViewModel::class.java)
    }

    // ทำให้ข้อมูลวีดีโอจาก internet เป็น card หรือจัดกลุ่มข้อมูลนั่นเอง
    private var viewModelAdapter: DevByteAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentDevByteBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_dev_byte,
                container,
                false)
        // Set lifecycleOwner เพื่อให้ DataBinding เห็น LiveData
        binding.setLifecycleOwner(viewLifecycleOwner)

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        //ถ้า video click จะไปทำงงานที่ videoclick
        viewModelAdapter = DevByteAdapter(VideoClick {
            val packageManager = context?.packageManager ?: return@VideoClick

            // ทำให้สามารถติดต่อโดยตรงกับ launchurl หรือ ก็คือ youtube
            var intent = Intent(Intent.ACTION_VIEW, it.launchUri)
            if(intent.resolveActivity(packageManager) == null) {
                // ถ้าหากในเครื่องไม่มี youtube จะใช้ web url แทน
                intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
            }

            startActivity(intent)
        })

        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }


        // ดูว่า network error หรือเปล่า
        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })

        return binding.root //ส่งคืน view หรือก็คือ fragment_dev_byte ในหน้า layout
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    //หาก NetworkError จะแสดงข้อความแบบ Toast
    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }

    // ทำให้สามารถ link ไปยัง app youtube ได้
    private val DevByteVideo.launchUri: Uri
        get() {
            val httpUri = Uri.parse(url)
            return Uri.parse("vnd.youtube:" + httpUri.getQueryParameter("v"))
        }

    //หลังจากที่ onCreateView ทำงานเสดและ return กลับมาจะทำงานใน fun นี้ต่อเพื่อสร้าง card ข้อมูลมาใช้กับ view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.playlist.observe(viewLifecycleOwner, Observer<List<DevByteVideo>> { videos ->
            videos?.apply {
                viewModelAdapter?.videos = videos
            }
        })
    }
}

//เมื่อวีดีโอถูก click จะไปเอาข้อมูลจาก DevByteVideo เพื่อเปิด
class VideoClick(val block: (DevByteVideo) -> Unit) {

    fun onClick(video: DevByteVideo) = block(video)
}

// เป็น RecyclerView ใช้เพื่อทำให้ข้อมูลอยู่เป็นรายการ
class DevByteAdapter(val callback: VideoClick) : RecyclerView.Adapter<DevByteViewHolder>() {


    // video ที่เราจะเอาไปแสดง ถ้าไม่มีให้แจ้ง
    var videos: List<DevByteVideo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // ใช้เมื่อ เพื่อให้เป็นตัวยึดเพื่อแสดงรายการ
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevByteViewHolder {
        val withDataBinding: DevbyteItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                DevByteViewHolder.LAYOUT,
                parent,
                false)
        return DevByteViewHolder(withDataBinding)
    }

    override fun getItemCount() = videos.size

    //เพื่อให้แสดงเนื้อหาได้ตามตำแหน่งที่กำหนดไว้
    override fun onBindViewHolder(holder: DevByteViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.video = videos[position]
            it.videoCallback = callback
        }
    }

}

//ViewHolder ของ DevByte ทั้งหมดทำได้โดยการผูกข้อมูล คือ การผูกข้อมูลเพื่อให้แสดงผลได้โดยไม่ผิดเพี้ยน
class DevByteViewHolder(val viewDataBinding: DevbyteItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.devbyte_item
    }
}