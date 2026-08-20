from uuid import UUID

from fastapi import FastAPI, Depends, HTTPException
from starlette import status

from controllers.todo_controller import router as todo_router, router
from services.dependencies import get_todo_service
from services.todo_service import TodoService, TodoNotFoundError

app = FastAPI(title="Todo API")
app.include_router(todo_router)

@router.delete(path="/{todo_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_todo(
    todo_id: UUID,
    service: TodoService = Depends(get_todo_service),
):
    try:
        service.delete_todo(todo_id)
    except TodoNotFoundError as e:
        raise HTTPException(status_code=404, detail=str(e))