import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionEComponent } from './estructural-seccion-e.component';

describe('EstructuralSeccionEComponent', () => {
  let component: EstructuralSeccionEComponent;
  let fixture: ComponentFixture<EstructuralSeccionEComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionEComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionEComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
