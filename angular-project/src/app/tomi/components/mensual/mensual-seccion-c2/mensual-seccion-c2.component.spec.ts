import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC2Component } from './mensual-seccion-c2.component';

describe('MensualSeccionC2Component', () => {
  let component: MensualSeccionC2Component;
  let fixture: ComponentFixture<MensualSeccionC2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
