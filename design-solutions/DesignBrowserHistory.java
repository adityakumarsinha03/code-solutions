class BrowserHistory {

    int currentPage = 0;
    ArrayList<String> historyUrl;
    public BrowserHistory(String homepage) {
        this.historyUrl = new ArrayList<>();
        historyUrl.add(homepage);
    }
    
    public void visit(String url) {
        historyUrl.subList(currentPage+1, historyUrl.size()).clear();
        historyUrl.add(url);
        currentPage++;
    }
    
    public String back(int steps) {
        while(currentPage>0 && steps>0){
            steps--;
            currentPage--;
        }
        return historyUrl.get(currentPage);
    }
    
    public String forward(int steps) {
        while(currentPage<historyUrl.size()-1 && steps>0){
            steps--;
            currentPage++;
        }
        return historyUrl.get(currentPage);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */