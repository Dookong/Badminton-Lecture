package dk.minton.data
import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("etag")
    var etag: String,
    @SerializedName("items")
    var items: List<Item>,
    @SerializedName("kind")
    var kind: String,
    @SerializedName("nextPageToken")
    var nextPageToken: String,
    @SerializedName("pageInfo")
    var pageInfo: PageInfo
) {
    data class Item(
        @SerializedName("etag")
        var etag: String,
        @SerializedName("id")
        var id: String,
        @SerializedName("kind")
        var kind: String,
        @SerializedName("snippet")
        var snippet: Snippet,
        @SerializedName("status")
        var status: Status
    ) {
        data class Snippet(
            @SerializedName("channelId")
            var channelId: String,
            @SerializedName("channelTitle")
            var channelTitle: String,
            @SerializedName("description")
            var description: String,
            @SerializedName("playlistId")
            var playlistId: String,
            @SerializedName("position")
            var position: Int,
            @SerializedName("publishedAt")
            var publishedAt: String,
            @SerializedName("resourceId")
            var resourceId: ResourceId,
            @SerializedName("thumbnails")
            var thumbnails: Thumbnails,
            @SerializedName("title")
            var title: String
        ) {
            data class ResourceId(
                @SerializedName("kind")
                var kind: String,
                @SerializedName("videoId")
                var videoId: String
            )

            data class Thumbnails(
                @SerializedName("default")
                var default: Default,
                @SerializedName("high")
                var high: High,
                @SerializedName("maxres")
                var maxres: Maxres,
                @SerializedName("medium")
                var medium: Medium,
                @SerializedName("standard")
                var standard: Standard
            ) {
                data class Default(
                    @SerializedName("height")
                    var height: Int,
                    @SerializedName("url")
                    var url: String,
                    @SerializedName("width")
                    var width: Int
                )

                data class High(
                    @SerializedName("height")
                    var height: Int,
                    @SerializedName("url")
                    var url: String,
                    @SerializedName("width")
                    var width: Int
                )

                data class Maxres(
                    @SerializedName("height")
                    var height: Int,
                    @SerializedName("url")
                    var url: String,
                    @SerializedName("width")
                    var width: Int
                )

                data class Medium(
                    @SerializedName("height")
                    var height: Int,
                    @SerializedName("url")
                    var url: String,
                    @SerializedName("width")
                    var width: Int
                )

                data class Standard(
                    @SerializedName("height")
                    var height: Int,
                    @SerializedName("url")
                    var url: String,
                    @SerializedName("width")
                    var width: Int
                )
            }
        }

        data class Status(
            @SerializedName("privacyStatus")
            var privacyStatus: String
        )
    }

    data class PageInfo(
        @SerializedName("resultsPerPage")
        var resultsPerPage: Int,
        @SerializedName("totalResults")
        var totalResults: Int
    )
}