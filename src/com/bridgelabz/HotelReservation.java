package com.bridgelabz;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class HotelReservation {

    static MiamiHotels LakeWood= new MiamiHotels("LakeWood",3,110,80,90,80);
    static MiamiHotels BridgeWood = new MiamiHotels("BridgeWood",4,160,110,60,50);
    static MiamiHotels RidgeWood = new MiamiHotels("RidgeWood",5,220,100,150,40);

    public static void main(String[] args) {

        Optional<MiamiHotels> minimumCostHotel = Stream.of(LakeWood, BridgeWood, RidgeWood).min(Comparator.comparing(miamiHotels -> miamiHotels.getCost(1)));
        System.out.println("minimumCostHotel in Miami is "+ minimumCostHotel.get().getName());
    }

}
