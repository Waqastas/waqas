package com.example.smilemini

import java.io.Serializable

data class GetBundlesModel(
    var itemNumber:String,
    var purchaseRoles:String,
    var configuration:String,
    var priceInCents:Double,
    var filterClass:String,
    var description:String,
    var units:Double,
    var priority:Int,
    var availableFrom:Long,
    var availableTo:Long,
    var unitType:String,
    var usableDays:Int,
    var wrapperClass:String,
    var unitCreditSpecificationId:Int,
    var name:String,
    var productServiceMappings: List<ProductServiceMapping>? = null
):Serializable{

}
