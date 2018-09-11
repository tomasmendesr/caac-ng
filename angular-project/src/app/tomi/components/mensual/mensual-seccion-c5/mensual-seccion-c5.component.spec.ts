import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC5Component } from './mensual-seccion-c5.component';

describe('MensualSeccionC5Component', () => {
  let component: MensualSeccionC5Component;
  let fixture: ComponentFixture<MensualSeccionC5Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC5Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
