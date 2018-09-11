import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionC6Component } from './mensual-seccion-c6.component';

describe('MensualSeccionC6Component', () => {
  let component: MensualSeccionC6Component;
  let fixture: ComponentFixture<MensualSeccionC6Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionC6Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionC6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
