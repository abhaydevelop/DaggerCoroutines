package com.example.daggerandcoroutines

import com.google.gson.annotations.SerializedName

data class Country(
    val auth_code: Any? = null,
    val auth_message: String? = null,
    val `data`: Data? = null,
    val error: List<Any>? = null,
    val is_daily_quiz: Int? = null,
    val is_free_trail: Int? = null,
    val is_inAppActive: Int? = null,
    val is_inapp_purchase_active: Int? = null,
    val is_ios_price: Int? = null,
    val is_podcast: Int? = null,
    val is_ppekit: Int? = null,
    val is_study: Int? = null,
    val message: String? = null,
    val status: Boolean? = null
)

data class Data(
    val cat_wise_event_list: List<CatWiseEvent>? = null
)

data class CatWiseEvent(
    val event_list: List<Event>? = null,
    val id: String? = null,
    val name: String? = null
)

data class Event(
    val avalable_sheat: String? = null,
    val course_type: String? = null,
    val cover_image: String? = null,
    val desc_header_image: String? = null,
    val description: String? = null,
    val discounted_prise: String? = null,
    val event_cat: String? = null,
    val event_end_date: String? = null,
    val event_end_time: String? = null,
    val event_start_date: String? = null,
    val event_start_time: String? = null,
    val event_vanue: String? = null,
    val evn_capcity: String? = null,
    val evn_discount_mrp: String? = null,
    val free_ids: String? = null,
    val gst_include: String? = null,
    val id: String? = null,
    val installment: List<Installment>? = null,
    val instructor_id: String? = null,
    val is_instalment: String? = null,
    val is_locked: String? = null,
    val is_purchased: String? = null,
    val is_subscription: String? = null,
    val is_testing: String? = null,
    val mrp: String? = null,
    val before_discount_mrp: String? = null,
    val publish: String? = null,
    val rating: String? = null,
    val review_count: String? = null,
    val state: String? = null,
    val test_type_master: String? = null,
    val title: String? = null,
    val seat_type: String? = null,
    val is_free_trial: Boolean? = null,
    val by_free_trial: String? = null,
    val user_installment_data: List<Any>,
    @SerializedName("subcenter_id") val subCenterId: String? = null,
    @SerializedName("availability_course") val availabilityCourse: String? = null,
    @SerializedName("booking_type") val bookingType: String? = null,
    @SerializedName("is_cbt") val isCbt: String? = null,
    @SerializedName("cbt_package_id") val cbtPackageId: String? = null,
    @SerializedName("is_renew") val isRenew: String? = null,
    @SerializedName("refund_status") val refundStatus: String? = null,
    @SerializedName("stage_type") val stageType: String? = null,
    @SerializedName("subject_id") val subjectId: String? = null,
)

data class Installment(
    val amount_description: AmountDescription? = null,
    val count: String? = null,
    val cycle: String? = null,
    val id: String? = null,
    val name: String? = null
)

data class AmountDescription(
    val base_amount: String? = null,
    val cycle: List<String>? = null,
    val emi_paid_count: Int? = null,
    val expiry: String? = null,
    val for_dams: String? = null,
    val for_non_dams: String? = null,
    val for_sub_id_ios: String? = null,
    val grace: String? = null,
    val loan_amt: String? = null,
    val panelty: String? = null,
    val panelty_type: String? = null,
    val payment: List<String>? = null,
    val subscription_code: String? = null
)