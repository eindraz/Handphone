package com.wahyuindra.handphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.handphone_add_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HandphoneAddFragment : Fragment() {

    private var namaInput : String = ""
    private var osInput : String = ""
    private var chipsetInput : String = ""
    private var displayInput : String = ""
    private var cameraInput : String = ""
    private var memoryInput : String = ""
    private var batteryInput : String = ""
    private var hargaInput : String = ""

    private var db: AppDatabase? = null
    private var vHandphoneDAO: HandphoneDAO? = null


    companion object {
        fun newInstance(): HandphoneAddFragment {
            return HandphoneAddFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.handphone_add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        vHandphoneDAO = db?.HandphoneDAO()
    }

    private fun initView() {
        btnSave.setOnClickListener { validasiInput() }
     }

    private fun validasiInput() {
        namaInput = edtNama.text.toString()
        osInput = edtOS.text.toString()
        chipsetInput = edtChipset.text.toString()
        displayInput = edtDisplay.text.toString()
        cameraInput = edtCamera.text.toString()
        memoryInput = edtMemory.text.toString()
        batteryInput = edtBattery.text.toString()
        hargaInput = edtHarga.text.toString()

        when{
            namaInput.isEmpty() -> edtNama.error = "Nama tidak boleh kosong"
            osInput.isEmpty() -> edtOS.error = "OS tidak boleh kosong"
            chipsetInput.isEmpty() -> edtChipset.error = "Chipset tidak boleh kosong"
            displayInput.isEmpty() -> edtDisplay.error = "Display tidak boleh kosong"
            cameraInput.isEmpty() -> edtCamera.error = "Camera tidak boleh kosong"
            memoryInput.isEmpty() -> edtMemory.error = "Memory tidak boleh kosong"
            batteryInput.isEmpty() -> edtBattery.error = "Battery tidak boleh kosong"
            hargaInput.isEmpty() -> edtHarga.error = "Harga tidak boleh kosong"

            else -> {

                val handphone = Handphone(nama = namaInput, os = osInput, chipset = chipsetInput, display = displayInput, camera = cameraInput, memory = memoryInput, battery = batteryInput, harga = hargaInput)
                tambahDataHandphone(handphone)

            }
        }

    }

    private fun tambahDataHandphone(handphone: Handphone) : Job {

        return GlobalScope.launch {
            vHandphoneDAO?.tambahHandphone(handphone)
            (activity as MainActivity).tampilHandphoneFragment()
        }

    }

//    private fun tampilToast(message: String) {
//        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
//    }


    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }



}