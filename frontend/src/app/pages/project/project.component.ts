import { Component, computed, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RouterLink } from '@angular/router';
import { toSignal } from '@angular/core/rxjs-interop';
import { map } from 'rxjs';
import { PROJECTS } from '../../data/projects';

interface MockProjectColumn {
  id: number;
  projectId: number;
  name: string;
  position: number;
  createdAt: string;
  updatedAt: string;
}

interface MockTask {
  id: number;
  projectId: number;
  columnId: number;
  name: string;
  description: string;
  position: number;
  createdAt: string;
  updatedAt: string;
}

@Component({
  selector: 'app-project',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './project.component.html'
})
export class ProjectComponent {
  private route = inject(ActivatedRoute);
  private readonly mockTimestamp = '2026-10-15T09:00:00Z';

  columns: MockProjectColumn[] = [
    { id: 11, projectId: 1, name: 'To do', position: 0, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 12, projectId: 1, name: 'In progress', position: 1, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 13, projectId: 1, name: 'Done', position: 2, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp }
  ];

  tasks: MockTask[] = [
    { id: 101, projectId: 1, columnId: 11, name: 'Map the current experience', description: 'Review key journeys and identify friction points.', position: 0, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 102, projectId: 1, columnId: 11, name: 'Prepare the design brief', description: 'Gather goals, constraints, and reference material.', position: 1, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 103, projectId: 1, columnId: 12, name: 'Create the new homepage layout', description: 'Explore a clearer hierarchy for the main landing page.', position: 0, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 104, projectId: 1, columnId: 12, name: 'Build the navigation prototype', description: 'Test the updated information architecture.', position: 1, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 105, projectId: 1, columnId: 13, name: 'Audit existing pages', description: 'Document content and reusable page patterns.', position: 0, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp },
    { id: 106, projectId: 1, columnId: 13, name: 'Collect stakeholder feedback', description: 'Summarize the first round of review notes.', position: 1, createdAt: this.mockTimestamp, updatedAt: this.mockTimestamp }
  ];

  private projectId = toSignal(
    this.route.paramMap.pipe(
      map(params => params.get('id'))
    ),
    { initialValue: null }
  );

  project = computed(() =>
    PROJECTS.find(p => p.id === this.projectId())
  );

  tasksForColumn(columnId: number): MockTask[] {
    return this.tasks
      .filter(task => task.columnId === columnId)
      .sort((first, second) => first.position - second.position);
  }
}