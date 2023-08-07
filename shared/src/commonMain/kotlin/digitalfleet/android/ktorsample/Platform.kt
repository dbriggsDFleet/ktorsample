package digitalfleet.android.ktorsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform