import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit{
  persons : any;
  title = 'appBootstrap';

  // @ts-ignore
  closeResult: string;
  constructor(private http : HttpClient,private modalService: NgbModal) {}
  // @ts-ignore
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
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
    this.http.get("http://localhost:8888/RESERVATIONS-SERVICE/persons").subscribe(
      {
        next : data => {
          this.persons = data
        },
        error : err => {
          console.log(err)
        }
      }
    )
  }

}
