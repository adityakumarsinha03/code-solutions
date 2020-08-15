// https://leetcode.com/problems/search-suggestions-system/submissions/

class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String> > searchAns = new ArrayList<>();
        
        List<String> prevSearch = null;
        for(int i = 0; i<searchWord.length(); i++){
            searchAns.add(new ArrayList<>());
            // first character
            if(i == 0){
                List<String> currSearch = new ArrayList<>();
                for(String str : products){
                    if(i<str.length() && str.charAt(i) == searchWord.charAt(i))
                        currSearch.add(str);
                }
                Collections.sort(currSearch);
                for(int j = 0; j<currSearch.size() && j<3; j++)
                    searchAns.get(i).add(currSearch.get(j));
                
                prevSearch = currSearch;
            } else{
                List<String> currSearch = new ArrayList<>();
                for(String str : prevSearch){
                    if(i<str.length() && str.charAt(i) == searchWord.charAt(i))
                        currSearch.add(str);
                }
                for(int j = 0; j<currSearch.size() && j<3; j++)
                    searchAns.get(i).add(currSearch.get(j));
                
                prevSearch = currSearch;
            }
        }
        return searchAns;
    }
}