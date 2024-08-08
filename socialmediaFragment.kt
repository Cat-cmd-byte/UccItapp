package com.example.uccitapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class SocialMediaFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var facebookButton: Button
    private lateinit var instagramButton: Button
    private lateinit var youtubeButton: Button
    private lateinit var linkedInButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_socialmedia, container, false)
        webView = view.findViewById(R.id.webview)
        facebookButton = view.findViewById(R.id.button_facebook)
        instagramButton = view.findViewById(R.id.button_instagram)
        youtubeButton = view.findViewById(R.id.button_youtube)
        linkedInButton = view.findViewById(R.id.button_linkedIn)

        setupWebView()
        setupButtons()

        return view
    }

    private fun setupWebView() {
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
    }

    private fun setupButtons() {
        facebookButton.setOnClickListener {
            webView.loadUrl("https://www.facebook.com/uccjamaica")
        }
        instagramButton.setOnClickListener {
            webView.loadUrl("https://www.instagram.com/uccjamaica/")
        }
        youtubeButton.setOnClickListener {
            webView.loadUrl("https://www.youtube.com/uccjamaica")
        }
        linkedInButton.setOnClickListener {
            webView.loadUrl("https://www.linkedin.com/company/uccjamaica")
        }
    }
}
