import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionE3Component } from './estructural-seccion-e3.component';

describe('EstructuralSeccionE3Component', () => {
  let component: EstructuralSeccionE3Component;
  let fixture: ComponentFixture<EstructuralSeccionE3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionE3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionE3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
