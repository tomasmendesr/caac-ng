import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportesViewComponent } from './reportes-view.component';

describe('ReportesViewComponent', () => {
  let component: ReportesViewComponent;
  let fixture: ComponentFixture<ReportesViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportesViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
