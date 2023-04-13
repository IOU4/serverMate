import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Image } from './image';

@Injectable({
  providedIn: 'root'
})
export class ImagesService {

  constructor(private http: HttpClient) { }

  baseApi = "http://localhost:8080/api/v1"

  getAllImages() {
    return this.http.get<Image[]>(`${this.baseApi}/image`);
  }
  deleteImage(imageId: string) {
    return this.http.delete(`${this.baseApi}/image/${imageId}`)
  }
}
