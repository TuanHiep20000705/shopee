package com.mth.example.shoppe

sealed class BottomNavItem(var title: String, var iconId: Int, var screenRoute: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Mall : BottomNavItem("Mall", R.drawable.ic_mall, "mall")
    object Live : BottomNavItem("Live", R.drawable.ic_live, "live")
    object Notification : BottomNavItem("Thông báo", R.drawable.ic_notification, "notification")
    object MyProfile : BottomNavItem("Tôi", R.drawable.ic_profile, "myprofile")
}
