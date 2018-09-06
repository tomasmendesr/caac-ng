import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaacViewComponent } from './caac-view.component';

describe('CaacViewComponent', () => {
  let component: CaacViewComponent;
  let fixture: ComponentFixture<CaacViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaacViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaacViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
