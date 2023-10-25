package com.ihrsachin.apostle.sample_data

import com.ihrsachin.apostle.model.Fee

class FeeData {
    companion object{
        private val sampleData = mutableListOf(
            Fee("Registration Fee", 50),
            Fee("Tuition Fee", 500),
            Fee("Book Fee", 75),
            Fee("Lab Fee", 100),
            Fee("Library Fee", 25),
            Fee("Sports Fee", 75),
            Fee("Exam Fee", 80),
            Fee("Transportation Fee", 120),
            Fee("Security Fee", 30),
            Fee("Miscellaneous Fee", 40)
        )

        init {
            var totalFee = 0
            for(fee in sampleData){
                totalFee += fee.feeValue
            }
            sampleData.add(Fee("Total Due", totalFee))
        }

        fun getData() : List<Fee>{
            return  sampleData
        }
    }

}