import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionBComponent } from './estructural-seccion-b.component';

describe('EstructuralSeccionBComponent', () => {
  let component: EstructuralSeccionBComponent;
  let fixture: ComponentFixture<EstructuralSeccionBComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionBComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionBComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
