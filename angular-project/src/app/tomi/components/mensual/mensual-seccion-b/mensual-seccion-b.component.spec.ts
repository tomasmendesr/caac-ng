import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionBComponent } from './mensual-seccion-b.component';

describe('MensualSeccionBComponent', () => {
  let component: MensualSeccionBComponent;
  let fixture: ComponentFixture<MensualSeccionBComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionBComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionBComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
