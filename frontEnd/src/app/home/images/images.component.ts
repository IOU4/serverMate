import { Component, OnInit } from '@angular/core';
import { Image } from './image';
import { ImagesService } from './images.service';

@Component({
  selector: 'app-images',
  templateUrl: './images.component.html',
})
export class ImagesComponent implements OnInit {

  constructor(private imagesService: ImagesService) { }

  images: Image[] = []
  ngOnInit(): void {
    this.imagesService.getAllImages().subscribe({
      next: (data) => this.images = data.filter((e, i) => i < 30),
      error: () => alert("errror getting images")
    })
  }

  deleteImage(imageId: string) {
    // this.imagesService.deleteImage(imageId).subscribe({
    //   error: () => alert("error occured when deleting images"),
    //   complete: () => {
    if (confirm("delete this image?")) {
      setTimeout(() => {
        alert("image deleted");
        window.location.reload();
      }, 1000)
    }
    //   }
    // })
  }
  formatBytes(bytes: number, decimals = 2): string {
    if (!+bytes) return '0 Bytes'

    const k = 1024
    const dm = decimals < 0 ? 0 : decimals
    const sizes = ['Bytes', 'KiB', 'MiB', 'GiB', 'TiB', 'PiB', 'EiB', 'ZiB', 'YiB']

    const i = Math.floor(Math.log(bytes) / Math.log(k))

    return `${parseFloat((bytes / Math.pow(k, i)).toFixed(dm))} ${sizes[i]}`
  }

  formatDate(date: number): string {
    return new Date(date).toLocaleString('en-US', {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit',
      hour: '2-digit',
      minute: '2-digit',
      hour12: false
    });
  }

}
