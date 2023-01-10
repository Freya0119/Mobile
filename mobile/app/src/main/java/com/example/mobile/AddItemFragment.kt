package com.example.mobile

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.icu.text.DateIntervalFormat.FormattedDateInterval
import android.os.Bundle
import android.os.PersistableBundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile.databinding.AddItemFragmentBinding
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import java.text.SimpleDateFormat
import java.time.Year
import java.time.format.DateTimeFormatter
import java.util.*

class AddItemFragment : Fragment() {
    private var _binding: AddItemFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = AddItemFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            addItemDateEditText.setOnClickListener { dateEditorClick() }
            addItemApplyButton.setOnClickListener {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dateEditorClick() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            this.requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                calendar.set(year, month, day)
                binding.addItemDateEditText.setText(
                    "${
                        SimpleDateFormat("yyyy/MM/dd").format(
                            calendar.time
                        )
                    }"
                )
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}