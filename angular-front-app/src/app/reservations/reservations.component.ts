import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit{
  reservations : any;
  person : any;
  resource : any;
  title = 'appBootstrap';

  // @ts-ignore
  closeResult: string;
  constructor(private http : HttpClient,private modalService: NgbModal) {}
  // @ts-ignore
  open(content,person) {
    this.person = person;
    console.log(person)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then(
      (result) => {
      this.closeResult = `Closed with: ${result}`;

      },
      (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/RESERVATIONS-SERVICE/reservations").subscribe(
      {
        next : data => {
          this.reservations = data
        },
        error : err => {
          console.log(err)
          console.log("ERROR")
        }
      }
    )
  }
  // @ts-ignore
  openr(content,resource) {
    this.resource = resource;
    console.log(resource)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;

      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      });
  }

  deleteReservation(id:number) {
    this.http.delete("http://localhost:8888/RESERVATIONS-SERVICE/reservations/delete/"+id)
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
