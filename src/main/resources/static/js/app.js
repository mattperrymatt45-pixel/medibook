// ── Delete confirmation using SweetAlert2 ──────────────────────────────────
function confirmDelete(btn) {
    const url = btn.getAttribute('data-url');
    Swal.fire({
        title: 'Are you sure?',
        text: 'This action cannot be undone.',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#6c757d',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = url;
        }
    });
}

// ── Real-time appointment slot validation ──────────────────────────────────
(function () {
    const doctorSelect = document.getElementById('doctorSelect');
    const apptDate    = document.getElementById('apptDate');
    const apptTime    = document.getElementById('apptTime');
    const warning     = document.getElementById('slotWarning');

    if (!doctorSelect || !apptDate || !apptTime) return;

    function checkSlot() {
        if (!doctorSelect.value || !apptDate.value || !apptTime.value) {
            warning.classList.add('d-none');
            return;
        }

        // existingAppointments is injected by Thymeleaf in the appointments page
        if (typeof existingAppointments === 'undefined') return;

        const conflict = existingAppointments.some(a => {
            return String(a.doctor.id) === String(doctorSelect.value) &&
                   a.apptDate          === apptDate.value &&
                   a.apptTime          === apptTime.value;
        });

        warning.classList.toggle('d-none', !conflict);
    }

    doctorSelect.addEventListener('change', checkSlot);
    apptDate.addEventListener('change', checkSlot);
    apptTime.addEventListener('change', checkSlot);
})();
