<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">

        <div class="modal-content shadow-sm border-0">
            <form action="../create-category" method="post">
                <div class="modal-header bg-dark text-light">
                    <h1>NEW GATEGORY</h1>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input name="title" type="text" class="form-control" id="title"
                               placeholder="category title">
                    </div>
                </div>

                <div class="modal-footer d-flex justify-content-center p-0">
                    <button type="submit" class="btn btn-primary">SAVE</button>
                </div>
            </form>
        </div>

    </div>
</div>