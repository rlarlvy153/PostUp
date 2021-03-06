package kr.co.youngcha.postup.network.model.user

import com.google.gson.annotations.SerializedName

class UserInfo (
    @SerializedName("id")
    val userId:Long,

    @SerializedName("nickname")
    val nickname:String,

    @SerializedName("pu_post_ids")
    val postIdList : List<Long>
)