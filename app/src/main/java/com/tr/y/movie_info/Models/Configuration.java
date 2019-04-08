package com.tr.y.movie_info.Models;

import com.tr.y.movie_info.Models.Images;

import java.util.ArrayList;

public class Configuration {
 Images ImagesObject;

 public Images getImagesObject() {
  return ImagesObject;
 }

 public void setImagesObject(Images imagesObject) {
  ImagesObject = imagesObject;
 }

 public ArrayList<String> getChange_keys() {
  return change_keys;
 }

 public void setChange_keys(ArrayList<String> change_keys) {
  this.change_keys = change_keys;
 }

 ArrayList<String> change_keys = new ArrayList<String>();


}