import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionAComponent } from './mensual-seccion-a.component';

describe('MensualSeccionAComponent', () => {
  let component: MensualSeccionAComponent;
  let fixture: ComponentFixture<MensualSeccionAComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionAComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
