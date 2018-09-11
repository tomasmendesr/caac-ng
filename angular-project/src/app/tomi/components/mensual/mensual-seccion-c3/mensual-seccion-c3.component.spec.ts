import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC3Component } from './mensual-seccion-c3.component';

describe('MensualSeccionC3Component', () => {
  let component: MensualSeccionC3Component;
  let fixture: ComponentFixture<MensualSeccionC3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
