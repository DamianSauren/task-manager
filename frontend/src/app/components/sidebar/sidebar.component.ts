import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { PROJECTS } from '../../data/projects';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent {
  projects = PROJECTS;
}