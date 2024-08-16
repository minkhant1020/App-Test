package mkkcom.example.apptest.userinterface.fragments

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.database.DataBaseSSActivity
import mkkcom.example.apptest.database.DatabaseActivity
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.databinding.FragmentAddProductBinding
import mkkcom.example.apptest.databinding.FragmentAddProductSSBinding
import mkkcom.example.apptest.helper.MyApp
import kotlin.random.Random


class AddProductSSFragment : BaseFragment<FragmentAddProductSSBinding>() {

    companion object {
        const val PRODUCT = "isEditMode"
        fun getInstance(product: Product? = null): AddProductFragment {
            val fragment = AddProductFragment()
            val bundle = Bundle()
            //bundle.putParcelable(PRODUCT,product)
            bundle.putSerializable(PRODUCT,product)
            fragment.arguments = bundle
            return fragment
        }
    }
    private var editProduct: Product? = null
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentAddProductSSBinding {
        return FragmentAddProductSSBinding.inflate(Inflater,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editProduct =arguments?.getSerializable(PRODUCT) as? Product
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.editProduct?.let {
            binding.edtProductName.setText(it.name)
            binding.edtProductDesc.setText(it.description)
        }

        binding.btnInsertProduct.text = if (editProduct != null )"Update" else "Add"
        binding.btnInsertProduct.setOnClickListener {
            if (editProduct != null){
                updateProduct()
            }else{
                addProduct()
            }
             }
    }

     private fun addProduct() {
         val name = binding.edtProductName.text.toString()
         val desc = binding.edtProductDesc.text.toString()
        val price = Random.nextInt(500, 1000).toDouble()
        val brand = "My Brand"

         val product = Product(
             id = 0,
             name = name,
             description = desc,
             price = price,
             brand = brand
         )



        AsyncTask.execute {
            (requireActivity().application as MyApp).db.productDao().insert(product)
            requireActivity().runOnUiThread { parentFragmentManager.popBackStackImmediate() }
            (requireActivity() as? DataBaseSSActivity)?.refreshAdapterForNewProduct(product)
        }

    }

    private fun updateProduct(){

        val name = binding.edtProductName.text.toString()
        val desc = binding.edtProductDesc.text.toString()

        val product = Product(
            id = editProduct!!.id,
            name = name,
            description = desc,
            price = editProduct!!.price,
            brand = editProduct!!.brand
        )

        AsyncTask.execute {
            (requireActivity().application as MyApp).db.productDao().update(product)
            requireActivity().runOnUiThread { parentFragmentManager.popBackStackImmediate() }
            (requireActivity() as? DataBaseSSActivity)?.refreshAdapterForUpdatedProduct(product)
        }

    }



}