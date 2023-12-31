import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonsComponent } from './persons.component';

describe('PersonsComponent', () => {
  let component: PersonsComponent;
  let fixture: ComponentFixture<PersonsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonsComponent]
    });
    fixture = TestBed.createComponent(PersonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
