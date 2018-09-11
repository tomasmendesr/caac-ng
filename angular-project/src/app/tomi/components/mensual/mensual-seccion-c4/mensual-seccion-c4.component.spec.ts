import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC4Component } from './mensual-seccion-c4.component';

describe('MensualSeccionC4Component', () => {
  let component: MensualSeccionC4Component;
  let fixture: ComponentFixture<MensualSeccionC4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
