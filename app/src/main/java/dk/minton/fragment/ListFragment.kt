package dk.minton.fragment

import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
    val part = "snippet,status"
    val fieds = "nextPageToken,items(snippet(publishedAt,title,resourceId,thumbnails),status)"
    val playlistid = "PLGhOCcpfhWjfqBvakt9CaKDuYnjlBl8Kt"
    val maxresults = "30"
    val apikey = "AIzaSyBEQ7BqYdHEzHiaZlgFoS7M3T2pTpPhHMg"
}