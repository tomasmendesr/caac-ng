import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC1Component } from './mensual-seccion-c1.component';

describe('MensualSeccionC1Component', () => {
  let component: MensualSeccionC1Component;
  let fixture: ComponentFixture<MensualSeccionC1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
