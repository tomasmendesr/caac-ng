import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionE2Component } from './estructural-seccion-e2.component';

describe('EstructuralSeccionE2Component', () => {
  let component: EstructuralSeccionE2Component;
  let fixture: ComponentFixture<EstructuralSeccionE2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionE2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionE2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
