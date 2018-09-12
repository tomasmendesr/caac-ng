import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCaacSelectionComponent } from './header-caac-selection.component';

describe('HeaderCaacSelectionComponent', () => {
  let component: HeaderCaacSelectionComponent;
  let fixture: ComponentFixture<HeaderCaacSelectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderCaacSelectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderCaacSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
