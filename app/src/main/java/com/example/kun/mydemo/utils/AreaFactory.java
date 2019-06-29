package com.example.kun.mydemo.utils;

public class AreaFactory {

    public static int getSpinnerIndex(int area){
        int sindex = 0;
        if(area >9 && area < 19){
            area -= 10 ;
        }else{
            switch (area){
                case 20:
                    sindex = 9 ;
                    break ;
                case 10:
                    sindex = 10 ;
                    break ;
                case 11:
                    sindex = 11 ;
                    break ;
                default:
                    sindex = 0 ;
                    break;
            }
        }
        return sindex ;
    }

    public static  int getAreaIndex(int sindex){
        int area = 0;
        if(sindex < 9){
            area += 10 ;
        }else{
            switch (sindex){
                case 9:
                    area = 20 ;
                    break ;
                case 10:
                    area = 30 ;
                    break ;
                case 11:
                    area = 40 ;
                    break ;
                    default:
                        area = 10 ;
                        break;
            }
        }

        return area;
    }
}
