import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionHComponent } from './estructural-seccion-h.component';

describe('EstructuralSeccionHComponent', () => {
  let component: EstructuralSeccionHComponent;
  let fixture: ComponentFixture<EstructuralSeccionHComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionHComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionHComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
