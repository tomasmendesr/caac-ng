import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrativoViewComponent } from './administrativo-view.component';

describe('AdministrativoViewComponent', () => {
  let component: AdministrativoViewComponent;
  let fixture: ComponentFixture<AdministrativoViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrativoViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrativoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
