package com.example.yogiyo_project.src.addressoption.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AddressResponse {
    public class KakaoAddress{

            public class Address{

                private String address_name;
                private String main_address_no;
                private String region_3depth_name;

                public String getAddress_name() {
                    return address_name;
                }

                public String getMain_address_no() {
                    return main_address_no;
                }

                public String getRegion_3depth_name() {
                    return region_3depth_name;
                }
            }
            private Address address;

            @SerializedName("address_name")
            private String road_address;

            @SerializedName("x")
            private String addressLongitude;

            @SerializedName("y")
            private String addressLatitude;

        public Address getAddress() {
            return address;
        }

        public String getRoad_address() {
            return road_address;
        }

        public String getAddressLongitude() {
            return addressLongitude;
        }

        public String getAddressLatitude() {
            return addressLatitude;
        }
    }
    @SerializedName("documents")
    private ArrayList<KakaoAddress> kakaoAddress;

    public ArrayList<KakaoAddress> getKakaoAddress() {
        return kakaoAddress;
    }
}
