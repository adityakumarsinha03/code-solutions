public class Codec {

    int autoIncId = 1;
    Map<String, String> urlMp;
    
    String charArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    public Codec(){
        this.urlMp = new HashMap<>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = autoIncId++;
        String shortUrl = "";
        while(id > 0){
            shortUrl += charArr.charAt(id%62);
            id = id/62;
        }
        shortUrl = "http://tinyurl.com/" + shortUrl;
        urlMp.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));