import { Component, inject } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatChipEditedEvent, MatChipInputEvent } from '@angular/material/chips';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { VideoService } from "../video.service";
import { MatSnackBar } from "@angular/material/snack-bar";
import { ActivatedRoute } from "@angular/router";


@Component({
	selector: 'app-save-video-details',
	templateUrl: './save-video-details.component.html',
	styleUrls: ['./save-video-details.component.css']
})
export class SaveVideoDetailsComponent {


	edit(_t56: String, $event: MatChipEditedEvent) {
		throw new Error('Method not implemented.');
	}

	saveVideoDetailsForm: FormGroup;
	title: FormControl = new FormControl('');
	description: FormControl = new FormControl('');
	videoStatus: FormControl = new FormControl('');


	addOnBlur = true;
	readonly separatorKeysCodes = [ENTER, COMMA] as const;
	tags: String[] = [];
	selectedFile!: File;
	selectedFileName = '';
	fileSelected = false;
	videoId = '';
	videoUrl!: string;
	thumbnailUrl!: string;


	constructor(private activatedRoute: ActivatedRoute, private videoService: VideoService,
		private matSnackBar: MatSnackBar) {
		this.videoId = this.activatedRoute.snapshot.params['videoId'];
		this.videoService.getVideo(this.videoId).subscribe(data => {
			this.videoUrl = data.videoUrl;
			this.thumbnailUrl = data.thumbnailUrl;
		})

		this.saveVideoDetailsForm = new FormGroup({
			title: this.title,
			description: this.description,
			videoStatus: this.videoStatus,
		})

	}

	//announcer = inject(LiveAnnouncer);

	add(event: MatChipInputEvent): void {
		const value = (event.value || '').trim();

		// Add our fruit
		if (value) {
			this.tags.push(value);
		}

		// Clear the input value
		event.chipInput!.clear();
	}

	remove(value: String): void {
		const index = this.tags.indexOf(value);

		if (index >= 0) {
			this.tags.splice(index, 1);

			//this.announcer.announce(`Removed ${value}`);
		}
	}

	onFileSelected(event: Event) {
		// @ts-ignore
		this.selectedFile = event.target.files[0];
		this.selectedFileName = this.selectedFile.name;
		this.fileSelected = true;
	}

	onUpload() {
		this.videoService.uploadThumbnail(this.selectedFile, this.videoId)
			.subscribe(() => {
				// show an upload success notification.
				this.matSnackBar.open("Thumbnail Upload Successful", "OK");
			})
	}
}
