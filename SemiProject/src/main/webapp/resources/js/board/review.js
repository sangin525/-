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
         if (star.className.indexOf(starClassUnactive) !== -1) {
            printRatingResult(result, index + 1);
            for (let i = 0; i <= index; i++) {
               stars[i].className = starClassActive;
            }
         } else {
            printRatingResult(result, index);
            for (let i = index + 1; i < stars.length; i++) {
               stars[i].className = starClassUnactive;
            }
         }
         // 별점 미선택시 알림
         if (result.textContent === '0/5') {
            alert('별점을 선택해 주세요!');
            return false;
         }
      };
   });
}

function printRatingResult(result, num = 0) {
  result.textContent = `${num}/5`;
  document.getElementById('ratingValue').value = num;  // <input> 태그의 value 업데이트
}

//이미지 업로드 js
window.addEventListener('DOMContentLoaded', () => {
    const fileInput = document.getElementById("fileUpload");
    const selectedFiles = []; // 선택한 파일들을 저장할 배열

    if (fileInput !== null) {
        const handleFiles = (e) => {
            const newFiles = [...fileInput.files]; // 새로 추가된 파일들
            const allFiles = selectedFiles.concat(newFiles); // 기존 파일들과 새로 추가된 파일들을 합침
            const previewContainer = document.getElementById("previewContainer");
            previewContainer.innerHTML = ""; // 기존의 미리보기를 초기화

            allFiles.forEach((file, index) => {
                const fileReader = new FileReader();

                fileReader.readAsDataURL(file);

                fileReader.onload = function () {
                    const previewDiv = document.createElement("div");
                    previewDiv.className = "image-container";

                    const previewImg = document.createElement("img");
                    previewImg.src = fileReader.result;
                    previewImg.width = 100;
                    previewImg.height = 100;

                    const removeButton = document.createElement("button");
                    removeButton.textContent = "Remove";
                    removeButton.className = "remove-button";
                    removeButton.onclick = function () {
                        previewContainer.removeChild(previewDiv);
                        const fileIndex = selectedFiles.indexOf(file);
                        if (fileIndex > -1) {
                            selectedFiles.splice(fileIndex, 1);
                        }
                    };

                    previewDiv.appendChild(previewImg);
                    previewDiv.appendChild(removeButton);
                    previewContainer.appendChild(previewDiv);
                };
            });

            selectedFiles.push(...newFiles); // 새로 추가된 파일들을 선택한 파일들 배열에 추가
        };

        fileInput.addEventListener("change", handleFiles);
    }
});
