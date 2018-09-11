import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CierrePeriodoComponent } from './cierre-periodo.component';

describe('CierrePeriodoComponent', () => {
  let component: CierrePeriodoComponent;
  let fixture: ComponentFixture<CierrePeriodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CierrePeriodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CierrePeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
