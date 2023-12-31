import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent implements OnInit{
  resources : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/RESOURCES-SERVICE/resources").subscribe(
      {
        next : data => {
          this.resources = data
        },
        error : err => {
          console.log(err)
        }
      }
    )
  }

  deleteResource(id :number) {
    this.http.delete("http://localhost:8888/RESOURCES-SERVICE/resources/delete/"+id)
      .subscribe(
        {
          next: value => {
            window.location.reload()
          },
          error: err => {
            console.log(err)
          }
        }
      )

  }
}
