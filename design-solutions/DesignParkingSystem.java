class ParkingSystem {

    int big, medium, small;
    List<Integer> carPark;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        
        carPark = new ArrayList<>();
        carPark.add(big);
        carPark.add(medium);
        carPark.add(small);
    }
    
    public boolean addCar(int carType) {
        if(carPark.get(carType-1) > 0){
            carPark.set(carType-1, carPark.get(carType-1)-1);
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */