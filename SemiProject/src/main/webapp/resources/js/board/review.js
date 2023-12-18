// HTML 문서의 로드가 완료된 후에 실행되도록 코드를 수정
window.addEventListener('DOMContentLoaded', () => {
	const ratingStars = [...document.getElementsByClassName("rating__star")];
	const ratingResult = document.querySelector(".rating__result");

	if (ratingResult !== null) {
		printRatingResult(ratingResult);
		executeRating(ratingStars, ratingResult);
	}
});


function executeRating(stars, result) {
	const starClassActive = "rating__star fas fa-star";
	const starClassUnactive = "rating__star far fa-star";

	stars.forEach((star, index) => {
		star.onclick = () => {
			const numStars = index + 1;
			printRatingResult(result, numStars);
			stars.forEach((star, i) => {
				star.className = i < numStars ? starClassActive : starClassUnactive;
			});
		};
	});

	// 폼 제출 이벤트 리스너
	document.querySelector('form').addEventListener('submit', function(e) {
		if (document.querySelector('#ratingValue').value === '0') {
			e.preventDefault();
			alert('별점을 선택해주세요.');
		}
	});
}

function generateStars(count) {
	let starsHTML = '';
	for (let i = 0; i < 5; i++) {
		if (i < count) {
			starsHTML += '<i class="fas fa-star"></i>';
		} else {
			starsHTML += '<i class="far fa-star"></i>';
		}
	}
	return starsHTML;
}

function printRatingResult(result, num = 0) {
	result.textContent = `${num}/5`;
	document.getElementById('ratingValue').value = num;  // <input> 태그의 value 업데이트
}

//이미지 업로드 js
window.addEventListener('DOMContentLoaded', () => {
    const selectedFiles = {}; // 선택한 파일들을 저장할 객체
    const previewContainer = document.getElementById("previewContainer");

    const handleFiles = (fileInput) => {
        const newFiles = [...fileInput.files]; // 새로 추가된 파일들
        selectedFiles[fileInput.id] = newFiles; // 새로 추가된 파일들을 선택한 파일들 객체에 추가

        newFiles.forEach((file, index) => {
            const fileReader = new FileReader();

            fileReader.readAsDataURL(file);

            fileReader.onload = function() {
                const previewDiv = document.createElement("div");
                previewDiv.className = "image-container";
                previewDiv.dataset.inputId = fileInput.id; // 미리보기 이미지가 어떤 input에 연결되어 있는지 표시
                previewDiv.dataset.fileIndex = index; // 미리보기 이미지가 어떤 파일에 연결되어 있는지 표시

                const previewImg = document.createElement("img");
                previewImg.src = fileReader.result;
                previewImg.width = 100;
                previewImg.height = 100;

                const removeButton = document.createElement("button");
                removeButton.textContent = "x";
                removeButton.className = "remove-button";
                removeButton.onclick = function() {
                    previewContainer.removeChild(previewDiv);
                    const fileIndex = selectedFiles[fileInput.id].indexOf(file);
                    if (fileIndex > -1) {
                        selectedFiles[fileInput.id].splice(fileIndex, 1);
                    }
                };

                previewDiv.appendChild(previewImg);
                previewDiv.appendChild(removeButton);
                previewContainer.appendChild(previewDiv);
            };
        });
    };
    
    const fileInputs = Array.from(document.querySelectorAll(".file-upload-input")); // 모든 input 요소를 배열로 가져옴
    let activeIndex = 0; // 현재 활성화된 input 요소의 인덱스

    const labels = document.querySelectorAll(".custom-file-upload"); // 모든 라벨 요소를 선택함
labels.forEach(label => { // 각 라벨 요소에 대해
    label.addEventListener("click", (event) => {
        // 라벨을 클릭하면 현재 활성화된 input 요소를 클릭하도록 이벤트를 발생시킴
        event.preventDefault();
        if (activeIndex < fileInputs.length) {
            fileInputs[activeIndex].click();
        }
    });
});

    fileInputs.forEach((fileInput, index) => {
        fileInput.addEventListener("change", () => {
            handleFiles(fileInput);
            // 파일을 성공적으로 업로드하면 인덱스를 증가시켜 다음 input 요소가 활성화되도록 함
            if (fileInput.files.length > 0 && activeIndex < fileInputs.length) {
                activeIndex++;
            }
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
	var yearInput = document.getElementById('year');
	var selectedYear = document.getElementById('selectedYear');
	var dropdownOptionsYear = document.getElementById('dropdownOptionsYear');
	var iconArrow = document.querySelector('#icon-year');

	if (yearInput && selectedYear) {
		yearInput.value = selectedYear.textContent;
	}

	if (selectedYear) {
		selectedYear.addEventListener('click', function(event) {
			if (dropdownOptionsYear.style.display === 'none') {
				dropdownOptionsYear.style.display = 'block';
				iconArrow.style.transform = 'translateY(-50%) rotate(0deg)';
			} else {
				dropdownOptionsYear.style.display = 'none';
				iconArrow.style.transform = 'translateY(-50%) rotate(180deg)';
			}
		});
	}

	if (dropdownOptionsYear) {
		dropdownOptionsYear.addEventListener('click', function(event) {
			var target = event.target;
			if (target.tagName === 'LI') {
				var value = target.getAttribute('data-value');
				selectedYear.textContent = value;
				yearInput.value = value;
				dropdownOptionsYear.style.display = 'none';
				iconArrow.style.transform = 'translateY(-50%) rotate(180deg)';
			}
		});
	}
});

document.addEventListener('DOMContentLoaded', function() {
	var selectedMonth = document.getElementById('selectedMonth');
	var dropdownOptionsMonth = document.getElementById('dropdownOptionsMonth');
	var monthInput = document.getElementById('month');
	var iconArrow = document.querySelector('#icon-month');

	if (monthInput && selectedMonth) {
		monthInput.value = selectedMonth.textContent;
	}

	if (selectedMonth) {
		selectedMonth.addEventListener('click', function(event) {
			if (dropdownOptionsMonth.style.display === 'none') {
				dropdownOptionsMonth.style.display = 'block';
				iconArrow.style.transform = 'translateY(-50%) rotate(0deg)';
			} else {
				dropdownOptionsMonth.style.display = 'none';
				iconArrow.style.transform = 'translateY(-50%) rotate(180deg)';
			}
		});
	}
	if (dropdownOptionsMonth) {
		dropdownOptionsMonth.addEventListener('click', function(event) {
			var target = event.target;
			if (target.tagName === 'LI') {
				var value = target.getAttribute('data-value');
				selectedMonth.textContent = value;
				monthInput.value = value;
				dropdownOptionsMonth.style.display = 'none';
				iconArrow.style.transform = 'translateY(-50%) rotate(180deg)';
			}
		});
	}

});
//제목 30글자 제한
window.addEventListener('DOMContentLoaded', () => {
	const titleInput = document.getElementById('title');
	const countSpan = document.querySelector('.column-text .text-muted');

	if (titleInput !== null && countSpan !== null) {
		titleInput.addEventListener('input', function() {
			let text = titleInput.value;
			if (text.length > 30) {
				// 30글자를 초과하면 초과 부분을 잘라냅니다.
				text = text.substring(0, 30);
				titleInput.value = text;
			}
			const textLength = text.length;
			countSpan.textContent = `(${textLength}/30)`;
		});
	}
});

window.addEventListener('DOMContentLoaded', () => {
	const content = document.getElementById('content');
	const countSpan = document.querySelector('.textarea-box .text-muted');

	if (content !== null && countSpan !== null) {
		content.addEventListener('input', function() {
			let text = content.value;
			if (text.length > 500) {
				// 500글자를 초과하면 초과 부분을 잘라냅니다.
				text = text.substring(0, 500);
				content.value = text;
			}
			const textLength = text.length;
			countSpan.textContent = `(${textLength}/500)`;
		});
	}
});

window.addEventListener('DOMContentLoaded', () => {
	const imgElement = document.querySelector('img');
	if (imgElement && !imgElement.src) {
		imgElement.style.display = 'none';
	}
});

function reviewDelete(button) {
    // 현재 클릭된 버튼의 가장 가까운 'form' 요소를 찾습니다.
    const form = button.closest("form");

    form.action = "/reviewDelete.do";
    form.method = "POST";
    form.submit();
}

function reviewUpdate(button) {
    // 현재 클릭된 버튼의 가장 가까운 'form' 요소를 찾습니다.
    const form = button.closest("form");

    form.action = "/board/reviewUpdateForm.do";
    form.method = "GET";
    form.submit();
}